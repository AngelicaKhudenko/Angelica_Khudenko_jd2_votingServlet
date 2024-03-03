package by.it_academy.jd2.voting.service.factory;

import by.it_academy.jd2.voting.dao.factory.DaoFactory;
import by.it_academy.jd2.voting.service.ClearService;
import by.it_academy.jd2.voting.service.StatService;
import by.it_academy.jd2.voting.service.VoteService;
import by.it_academy.jd2.voting.service.api.IClearService;
import by.it_academy.jd2.voting.service.api.IStatService;
import by.it_academy.jd2.voting.service.api.IVoteService;

public class ServiceFactory {
    private volatile static IStatService statService;
    private volatile static IVoteService voteService;
    private volatile static IClearService clearService;

    public static IStatService getStatService(){
        if (statService==null){
            synchronized (ServiceFactory.class){
                if (statService==null){
                    statService=new StatService(getVoteService());
                }
            }
        }
        return statService;
    }

    public static IVoteService getVoteService(){
        if (voteService==null){
            synchronized (ServiceFactory.class){
                if (voteService==null){
                    voteService=new VoteService(DaoFactory.getVoteDao());
                }
            }
        }
        return voteService;
    }

    public static IClearService getClearService(){
        if (clearService==null){
            synchronized (ServiceFactory.class){
                if (clearService==null){
                    clearService=new ClearService(getVoteService());
                }
            }
        }
        return clearService;
    }
}
