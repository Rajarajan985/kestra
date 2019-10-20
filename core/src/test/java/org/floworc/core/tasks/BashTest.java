package org.floworc.core.tasks;

import com.google.common.collect.ImmutableMap;
import io.micronaut.test.annotation.MicronautTest;
import org.floworc.core.runners.RunContext;
import org.floworc.core.storages.StorageInterface;
import org.floworc.core.tasks.scripts.Bash;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class BashTest {
    @Inject
    StorageInterface storageInterface;

    @Test
    void run() throws Exception {
        RunContext runContext = new RunContext(
            this.storageInterface,
            ImmutableMap.of(
                "input", ImmutableMap.of("url", "www.google.fr")
            )
        );

        Bash bash = Bash.builder()
            .commands(new String[]{"sleep 1", "curl {{ upper input.url }} > /dev/null", "echo 0", "sleep 1", "echo 1"})
            .build();

        bash.run(runContext);
    }
}