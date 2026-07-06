import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FormationController {

    @Autowired
    private FormationRepository formationRepository ;
    
    @RequestMapping(value = "/formations", method = RequestMethod.GET)
    public List<Formation> getFormations(){
        return formationRepository.getAllFormations() ;
    }
}
