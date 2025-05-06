package com.example.projetoescola.configs.validations;

import com.example.projetoescola.models.Usuario;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SenhasIguaisConstraint implements ConstraintValidator<SenhasIguaisValidation, Usuario> {
    @Override
    public boolean isValid(Usuario usuario, ConstraintValidatorContext context) {
        if (usuario.getSenha() == null || usuario.getConfirmarSenha() == null) {
            return false;
        }
        return usuario.getSenha().equals(usuario.getConfirmarSenha());
    }
}