package by.it_academy.jd2.voting.dao.factory;

import by.it_academy.jd2.voting.dao.VoteDao;
import by.it_academy.jd2.voting.dao.api.IVoteDao;

public class DaoFactory {
    private volatile static IVoteDao voteDao;

    public static IVoteDao getVoteDao(){
        if (voteDao==null){
            synchronized (DaoFactory.class){
                if (voteDao==null){
                    voteDao=new VoteDao();
                }
            }
        }
        return voteDao;
    }
}
