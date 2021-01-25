package org.kestra.core.services;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Getter;
import org.kestra.core.models.flows.TaskDefault;

import java.util.List;

@ConfigurationProperties(value = "kestra.tasks")
@Getter
public class TaskGlobalDefaultConfiguration {
    List<TaskDefault> defaults;
}
