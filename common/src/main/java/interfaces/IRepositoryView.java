package interfaces;

import java.util.List;

import model.Repository;

public interface IRepositoryView
{
    void showRepositories(List<Repository> allRepositories);
}