package com.example.atividade2;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade2.models.Diretor;
import com.example.atividade2.models.Filme;
import com.example.atividade2.repositories.DiretorRepository;
import com.example.atividade2.repositories.FilmeRepository;

@SpringBootApplication
public class Atividade2Application {

	@Bean
	CommandLineRunner inserirDados(DiretorRepository diretorRepository, FilmeRepository filmeRepository) {
		return args -> {
			Diretor d1 = new Diretor();
			d1.setNome("Steven Spielberg");

			Diretor d2 = new Diretor();
			d2.setNome("Christopher Nolan");

			Filme f1 = new Filme();
			f1.setTitulo("Jurassic Park");
			f1.setDuracao(127);
			f1.setDiretor(d1);

			Filme f2 = new Filme();
			f2.setTitulo("E.T.");
			f2.setDuracao(115);
			f2.setDiretor(d1);

			Filme f3 = new Filme();
			f3.setTitulo("Inception");
			f3.setDuracao(148);
			f3.setDiretor(d2);

			d1.setFilmes(Arrays.asList(f1, f2));
			d2.setFilmes(Arrays.asList(f3));

			diretorRepository.saveAll(Arrays.asList(d1, d2));

			System.out.println("Filmes com duração > 120 min:");
			filmeRepository.findByDuracaoGreaterThan(120).forEach(System.out::println);

			System.out.println("Filmes com duração <= 120 min:");
			filmeRepository.findByDuracaoLessThanEqual(120).forEach(System.out::println);

			System.out.println("Filmes que começam com 'J':");
			filmeRepository.findByTituloStartingWith("J").forEach(System.out::println);

			System.out.println("Diretores que começam com 'C':");
			diretorRepository.findByNomeStartingWith("C").forEach(System.out::println);

			System.out.println("Diretor com ID 2 e seus filmes:");
			Diretor d = diretorRepository.findByIdComFilmes(2L);
			System.out.println(d);
			d.getFilmes().forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade2Application.class, args);
	}

}
