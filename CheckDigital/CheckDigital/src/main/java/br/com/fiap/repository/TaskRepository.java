package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
