package com.izaiasvalentim.vendasapplication.domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izaiasvalentim.vendasapplication.domain.entity.Produto;
@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

}
