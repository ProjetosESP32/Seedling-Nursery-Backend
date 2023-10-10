package com.ifmt.seedlingNursery.exception;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(Long id, Class<?> entity) {
    /*
     * super("O(a) " + entity.getSimpleName().toLowerCase() + " com id '" + id +
     * "' não está cadastrada");
     */
    super("Cadastro não encontrado.");
  }

}
