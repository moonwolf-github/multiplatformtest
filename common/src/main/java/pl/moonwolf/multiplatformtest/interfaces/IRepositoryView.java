package pl.moonwolf.multiplatformtest.interfaces;

import java.util.List;

import pl.moonwolf.multiplatformtest.model.Repository;

public interface IRepositoryView
{
    void showRepositories(List<Repository> allRepositories);
}