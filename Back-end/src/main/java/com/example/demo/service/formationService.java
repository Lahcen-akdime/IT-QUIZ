import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Formation;
import com.example.demo.repository.FormationRepository;

@Service
public class formationService {

    @Autowired
    private FormationRepository formationRepository ;

    public List<Formation> getAllFormation(){
        return formationRepository.getAllFormations() ;
    }

}