package fr.softeam.java21.A_Loom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Loom {
    private final static Logger log = LoggerFactory.getLogger("Loom");
    public static final int NB_TASKS_OLD = 100_000;

    private final static AtomicInteger compteur = new AtomicInteger(0);
    private static LocalDateTime time;


    @Test
    void tachesAEffectuerEnParrallele() throws ExecutionException, InterruptedException {
        int nbTaches=50;

        List<Future<?>> futures = new ArrayList<>(nbTaches);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < nbTaches; i++) {
            futures.add(executorService.submit(getRunnable()));
        }
        for (Future<?> future : futures) {
            future.get();
        }
    }

    private static Runnable getRunnable() {
        return () -> {
            try {
                sleep(5000);
                compteur.incrementAndGet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void startDemonCompteurThread() {
        var t = new Thread(() -> {
            while (true) {
                log.info("Nb de threads terminés {}",compteur.get());
                try {
                    Thread.sleep(5000l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @BeforeEach
    void init(){
        startDemonCompteurThread();
        time = LocalDateTime.now();
    }


    @AfterEach
    void end(){
        log.info("Nb de threads terminés {}",compteur.get());
        log.info("Tps total {}",ChronoUnit.MILLIS.between(time, LocalDateTime.now()));
    }
}
