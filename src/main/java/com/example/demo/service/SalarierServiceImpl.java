package com.example.demo.service;

//import com.example.demo.dtos.POSTEmployerResponseDto
import com.example.demo.dtos.DeleteEmployerResponseDto;
import com.example.demo.dtos.GetEmployerResponseDto;
import com.example.demo.dtos.PostEmployerResponseDto;
import com.example.demo.dtos.UpdateEmployerResponseDto;
import com.example.demo.model.Salarier;
import com.example.demo.repository.SalarierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Slf4j
@Service

public class SalarierServiceImpl implements SalarierService {

    private final SalarierRepository salarierRepository;

    public SalarierServiceImpl(SalarierRepository salarierRepository) {

        this.salarierRepository = salarierRepository;
    }

   // public etudiantResponse getEtudiantById(int id) {
  //  }

    @Override
    public GetEmployerResponseDto lire(long id) {

        try {
            log.info("----get un employe dans le service etudiant id : {}", id);
            var res= WebClient.builder().build().get().uri("http://localhost:8081/Employer/"+id)
                     .retrieve().bodyToMono(GetEmployerResponseDto.class)
                     .block();
            log.info("----End et un employe dans le service etudiant res : {}", res);


            return res;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PostEmployerResponseDto creer(Salarier salarier) {
        try {
            var webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
            var res = webClient.post().uri("/Employer/create")
                    .bodyValue(salarier)
                    .retrieve()//envoie la requette et attend la reponse.
                    .bodyToMono(PostEmployerResponseDto.class)//converti la reponse de mon objet en Postem...
                    .block();//bloquer l'eception jusqu'a ce que j'obtient m'a reponse.
             /*res = WebClient.builder().build().put().uri("http://localhost:8081/Employer/create")
                    .retrieve().bodyToMono(PostEmployerResponseDto.class)
                    .block();
*/
            return res;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public  List<Salarier> lire() {
        return null;
    }

    @Override
    public UpdateEmployerResponseDto modifier(long id, Salarier salarier) {
        try {

                var webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
                var res = webClient.put().uri("/Employer/update/" + id)
                        .bodyValue(salarier)
                        .retrieve()
                        .bodyToMono(UpdateEmployerResponseDto.class)
                        .block();


                return res;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }

    }


    @Override
    public DeleteEmployerResponseDto supprimer(long id) {
       // etudiantRepository.deleteById(id);
       // return"employer suprimer!!";
/*
        try {
     var res= WebClient.builder().build().delete().uri("http://localhost:8081/Employer/"+id)
                    .retrieve().bodyToMono(DeleteEmployerResponseDto.class)
                    .block();*/

        try {
            var webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
            var res = webClient.delete().uri("/Employer/delete/"+ id)
                    .retrieve()
                    .bodyToMono(DeleteEmployerResponseDto.class)
                    .block();

            // If the deletion is successful, you can also delete the corresponding etudiant from your database
            salarierRepository.deleteById(id);

            return res;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}