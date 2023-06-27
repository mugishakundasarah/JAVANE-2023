package rw.pacis.ne.auth_boilerplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.pacis.ne.auth_boilerplate.models.Purchased;

import java.util.UUID;

@Repository
public interface IPurchasedRepository extends JpaRepository<Purchased, UUID> {
}
