package br.com.fiap.service;

import org.springframework.stereotype.Service;

import br.com.fiap.model.Task;
import br.com.fiap.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Task getTaskById(Long id) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		return optionalTask.orElse(null);
	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public Task updateTask(Long id, Task task) {
		if (taskRepository.existsById(id)) {
			task.setId(id);
			return taskRepository.save(task);
		}
		return null;
	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}
