package pl.moonwolf.multiplatformtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import pl.moonwolf.multiplatformtest.interfaces.IRepositoryView;
import pl.moonwolf.multiplatformtest.model.Repository;
import pl.moonwolf.multiplatformtest.presenter.RepositoryPresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements IRepositoryView
{
    private List<Repository> mAllRepositories = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RepositoriesAdapter mRepositoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.repository_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                LinearLayout.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        RepositoryPresenter repositoryPresenter = new RepositoryPresenter(this);
        repositoryPresenter.getRepositories(AndroidSchedulers.mainThread(), Schedulers.newThread());
    }

    @Override
    public void showRepositories(List<Repository> allRepositories)
    {
        mAllRepositories = allRepositories;
        mRepositoriesAdapter = new RepositoriesAdapter(mAllRepositories);
        mRecyclerView.setAdapter(mRepositoriesAdapter);
    }
}
