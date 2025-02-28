package com.example.ProjetoAlarme.Repository;

import com.example.ProjetoAlarme.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterFaceRepository extends JpaRepository<Produto, Integer> {
}
