package pl.moonwolf.multiplatformtest.presenter;

import java.util.List;

import pl.moonwolf.multiplatformtest.api.ServiceGenerator;
import pl.moonwolf.multiplatformtest.interfaces.GitHubApi;
import pl.moonwolf.multiplatformtest.interfaces.IRepositoryView;
import pl.moonwolf.multiplatformtest.model.Repository;
import rx.Scheduler;
import rx.Subscriber;

public class RepositoryPresenter
{
    private IRepositoryView mView;

    public RepositoryPresenter(IRepositoryView view)
    {
        mView = view;
    }

    public void getRepositories(Scheduler postThread, Scheduler subscribeThread)
    {
        GitHubApi gitHubApi = ServiceGenerator.createService(GitHubApi.class);
        gitHubApi.getRepos()
                .subscribeOn(subscribeThread)
                .observeOn(postThread)
                .subscribe(new Subscriber<List<Repository>>()
                {
                    @Override
                    public void onCompleted()
                    {
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                    }

                    @Override
                    public void onNext(List<Repository> repositories)
                    {
                        mView.showRepositories(repositories);
                    }
                });
    }
}