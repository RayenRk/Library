package org.example.library.Repository;

import org.apache.catalina.Loader;
import org.example.library.Entity.Emprunte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprunteRepository extends JpaRepository<Emprunte, Long> {
}