package pl.moonwolf.multiplatformtest.interfaces;

import java.util.List;

import pl.moonwolf.multiplatformtest.model.Repository;
import retrofit2.http.GET;
import rx.Observable;

public interface GitHubApi
{
    @GET("orgs/SnowdogApps/repos")
    Observable<List<Repository>> getRepos();
}
