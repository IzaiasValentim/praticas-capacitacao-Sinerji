package com.izaiasvalentim.vendasapplication.domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izaiasvalentim.vendasapplication.domain.entity.ItemPedido;
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
