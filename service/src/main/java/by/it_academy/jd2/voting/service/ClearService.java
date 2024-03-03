package by.it_academy.jd2.voting.service;

import by.it_academy.jd2.voting.service.api.IClearService;
import by.it_academy.jd2.voting.service.api.IVoteService;

public class ClearService implements IClearService {
    private final IVoteService voteService;

    public ClearService(IVoteService voteService) {
        this.voteService = voteService;
    }

    @Override
    public void clear() {
        voteService.clear();
    }
}
