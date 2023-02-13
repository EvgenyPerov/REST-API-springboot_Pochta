package my.home.services;

import my.home.models.*;
import my.home.repositories.StatusTrackRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatusTrackService {

    private StatusTrackRepository statusTrackRepository;

    private static final Logger logger = Logger.getLogger(StatusTrackService.class);

    @Autowired
    public StatusTrackService(StatusTrackRepository statusTrackRepository) {
        this.statusTrackRepository = statusTrackRepository;
    }

    public Status addTrack(Pack pack, Office office, TypeStatus typeStatus){
        Status status = Status.builder()
                .pack(pack)
                .office(office)
                .name(typeStatus)
                .date(new Date())
                .build();
        if (status != null)  {
            statusTrackRepository.save(status);
            logger.info("Добавлен трекер: " + pack + "; " + office + "; "+ typeStatus.name());
        }
        return status;
    }
    public List<Status> findTracksByPackIdentifier(String identifier){
        return statusTrackRepository.findStatusesByPackIdentifier(identifier);
    }

    public List<Status> findTracksByPackIndexExclComplete(Integer index) {

        List<Status> statusByOfficeIndex = statusTrackRepository
                .findStatusesByOfficeIndexAndNameNotLikeOrderByDate(index, TypeStatus.COMPLETE);


        List<Status> listComplitedStatuses = statusByOfficeIndex.stream().filter(track ->
            track.getName().equals(TypeStatus.COMPLETE)).collect(Collectors.toList());

        List<String> listIdentifComplete = new ArrayList<>();

        listComplitedStatuses.forEach(status -> {
            listIdentifComplete.add(status.getPack().getIdentifier());
        });

        List<Status> result = new ArrayList<>();
        for(Status status : statusByOfficeIndex){
            String identFromTotal = status.getPack().getIdentifier();
            if (listIdentifComplete.contains(identFromTotal)){

            } else {
                result.add(status);
            }
        }
        return getUniqueStatuses(result);

    }

    public List<Status> getUniqueStatuses(List<Status> statuses){
        List<Status> listSendOrReady = new ArrayList<>();
        for(Status status : statuses){
            if (status.getName().equals(TypeStatus.SEND) || status.getName().equals(TypeStatus.READY)) {
                listSendOrReady.add(status);
            }
        }
        List<Status> listForDelete= new ArrayList<>();
        for(Status delete : listSendOrReady){
            for(Status status : statuses){
                if (delete.getPack() == status.getPack() && status.getName().equals(TypeStatus.PROCESS)) {
                    listForDelete.add(status);
                }
            }
        }

        for (Status status : statuses) {
            if (status.getName().equals(TypeStatus.SEND)) {
                listForDelete.add(status);
            }
        }

        listForDelete.addAll(getCompletedStatuses(statuses));

        statuses.removeAll(listForDelete);

        return statuses;
    }

    public List<Status> getCompletedStatuses(List<Status> statuses){
        List<Status> listForDelete= new ArrayList<>();

        for (Status status : statuses) {
            String packIdent = status.getPack().getIdentifier();
            List<Status> listByIdent = statusTrackRepository.findStatusesByPackIdentifier(packIdent);

            for (Status item : listByIdent) {
                if (item.getName().equals(TypeStatus.COMPLETE)) {
                    listForDelete.addAll(listByIdent);
                }
            }
        }
    return listForDelete;
    }

    public List<Status> findAllTrackers(){
        return statusTrackRepository.findAll();
    }
}
