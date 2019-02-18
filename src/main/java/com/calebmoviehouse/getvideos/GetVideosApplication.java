package com.calebmoviehouse.getvideos;

import com.calebmoviehouse.getvideos.health.IsAliveCheck;
import com.calebmoviehouse.getvideos.resources.GetMockVideos;
import com.calebmoviehouse.getvideos.resources.PingService;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GetVideosApplication extends Application<GetVideosConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GetVideosApplication().run(args);
    }

    @Override
    public String getName() {
        return "GetVideos";
    }

    @Override
    public void initialize(final Bootstrap<GetVideosConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
    }

    @Override
    public void run(final GetVideosConfiguration configuration,
                    final Environment environment) {

        environment.jersey().register(new PingService());
        environment.jersey().register(new GetMockVideos());

        environment.healthChecks().register("IsAlive",new IsAliveCheck());
    }

}
