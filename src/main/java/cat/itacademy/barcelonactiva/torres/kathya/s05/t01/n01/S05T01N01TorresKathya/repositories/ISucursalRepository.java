package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.repositories;

import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.models.SucursalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISucursalRepository extends JpaRepository<SucursalModel, Long> {
}
