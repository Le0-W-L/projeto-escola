package com.example.projetoescola;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.example.projetoescola.models.Curso;
// import com.example.projetoescola.repositories.CursoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	// @Bean
	// public CommandLineRunner init(@Autowired CursoRepository cursoRepository) {
	// 	return args -> {
	// 		System.out.println("----- INSERINDO CURSOS -----");
	// 		cursoRepository.salvar(
	// 				new Curso(null, "teste", 2000));
	// 		cursoRepository.salvar(
	// 				new Curso(null, "teste2", 2050));
	// 		System.out.println("----- LISTANDO CURSOS -----");
	// 		List<Curso> listaCursos = cursoRepository.obterTodos();
	// 		listaCursos.forEach(System.out::println);
	// 	};
	// }

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
