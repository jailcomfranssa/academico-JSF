# academico-JSF
Aluno: Jailson Silva de França mat: 20182370048

Aluno: Rafael da Silva Marinho mat: 20142370368

==============================================
LINKs:=======================================
coodernador:

http://localhost:8080/academico/coodernador/cadastro.xhtml

http://localhost:8080/academico/coodernador/cadastroCood.xhtml

http://localhost:8080/academico/coodernador/consultaAluno.xhtml

http://localhost:8080/academico/coodernador/consultaProfessor.xhtml

http://localhost:8080/academico/coodernador/consultaCood.xhtml

turma:

http://localhost:8080/academico/turma/cadastro.xhtml

http://localhost:8080/academico/turma/consulta.xhtml

disciplina:

http://localhost:8080/academico/disciplina/cadastro.xhtml

http://localhost:8080/academico/disciplina/consulta.xhtml


usuarioTurma:

http://localhost:8080/academico/usuarioTurma/cadastro.xhtml

http://localhost:8080/academico/usuarioTurma/consultaAlunoTurma.xhtml

http://localhost:8080/academico/usuarioTurma/consultaProfessorTurma.xhtml

http://localhost:8080/academico/usuarioTurma/cadastroProfessorTurma.xhtml

Aula:

http://localhost:8080/academico/aula/cadastro.xhtml

http://localhost:8080/academico/aula/consulta.xhtml

Nota:

http://localhost:8080/academico/nota/cadastro.xhtml

http://localhost:8080/academico/nota/consulta.xhtml

Login

http://localhost:8080/academico/login/login.xhtml


SQL:

INSERT INTO `academico`.`tb_usuario` (`email`, `login`, `matricula`, `nome`, `senha`, `tipo`) VALUES ('aluno2@', 'aluno', '122', 'aluno', '123', 'ALUNO');

INSERT INTO `academico`.`tb_usuario` (`email`, `login`, `matricula`, `nome`, `senha`, `tipo`) VALUES ('professor', 'professor', '233', 'professor', '123', 'PROFESSOR');

INSERT INTO `academico`.`tb_usuario` (`email`, `login`, `matricula`, `nome`, `senha`, `tipo`) VALUES ('cood', 'cood', '888', 'coodernador', '123', 'PROFESSOR');


INSERT INTO `academico`.`tb_coodernador` (`ativo`, `usuario_id`) VALUES (1, 3);


