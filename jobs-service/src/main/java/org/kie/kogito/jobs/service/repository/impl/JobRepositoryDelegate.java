/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.jobs.service.repository.impl;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import io.quarkus.arc.DefaultBean;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.kie.kogito.jobs.service.model.JobStatus;
import org.kie.kogito.jobs.service.model.job.JobDetails;
import org.kie.kogito.jobs.service.qualifier.Repository;
import org.kie.kogito.jobs.service.repository.ReactiveJobRepository;
import org.kie.kogito.jobs.service.repository.infinispan.InfinispanConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DefaultBean
@ApplicationScoped
public class JobRepositoryDelegate implements ReactiveJobRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobRepositoryDelegate.class);

    private ReactiveJobRepository delegate;

    JobRepositoryDelegate() {
    }

    @Inject
    public JobRepositoryDelegate(@Any Instance<ReactiveJobRepository> instances,
                                 @ConfigProperty(name = InfinispanConfiguration.PERSISTENCE_CONFIG_KEY)
                                         Optional<String> persistence) {
        delegate = instances.select(BaseReactiveJobRepository.class,
                                    new Repository.Literal(persistence.orElse("in-memory"))).get();
        LOGGER.info("JobRepository selected {}", delegate.getClass());
    }

    @Override
    public CompletionStage<JobDetails> save(JobDetails job) {
        return delegate.save(job);
    }

    @Override
    public CompletionStage<JobDetails> get(String id) {
        return delegate.get(id);
    }

    @Override
    public CompletionStage<Boolean> exists(String id) {
        return delegate.exists(id);
    }

    @Override
    public CompletionStage<JobDetails> delete(String id) {
        return delegate.delete(id);
    }

    @Override
    public CompletionStage<JobDetails> delete(JobDetails job) {
        return delegate.delete(job);
    }

    @Override
    public PublisherBuilder<JobDetails> findByStatus(JobStatus... status) {
        return delegate.findByStatus(status);
    }

    @Override
    public PublisherBuilder<JobDetails> findAll() {
        return delegate.findAll();
    }

    @Override
    public PublisherBuilder<JobDetails> findByStatusBetweenDatesOrderByPriority(ZonedDateTime from, ZonedDateTime to, JobStatus... status) {
        return delegate.findByStatusBetweenDatesOrderByPriority(from, to, status);
    }

    @Override
    public CompletionStage<JobDetails> merge(String id, JobDetails job) {
        return delegate.merge(id, job);
    }
}
