# RoboMarteSpringBoot
Implementação da Interface do Robo com o SpringBoot

## O problema

Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte.
Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando essas imagens novamente para a Terra.

A posição de cada robô é representada pela combinação de coordenadas cartesianas (x, y) e por uma letra, que pode representar uma das quatro orientações: NORTH, SOUTH, EAST e WEST. Para simplificar a navegação, a região “marciana” a ser explorada foi subdividia em sub-regiões retangulares.
Uma posição válida de um robô, seria (0, 0, N), que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.
Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras ‘L’, ‘R’ e ‘M’. As letras ‘L’ e ‘R’ fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover da sua posição atual. A letra ‘M’ faz o robô deslocar-se uma posição para frente.
Assuma que um robô se movimenta para o NORTE em relação ao eixo y. Ou seja, um passo para o NORTE da posição (x,y), é a posição (x, y+1)
Exemplo: Se o robô está na posição (0,0,N), o comando "MML" fará ele chegar na posição (0,2,W)

Escreva um programa que permita aos engenheiros da NASA enviar comandos para o Robô e saber onde ele se encontra. Os engenheiros irão rodar testes no seu software para garantir que ele se comporta da forma esperada, antes de enviar o Robô para marte.

### Requisitos do desafio:

O terreno deverá ser iniciado com 5x5 posições;
O robô inicia na coordenada (0,0,N);
Deverá ser possível enviar um comando para o Robô que me retorne a posição final dele;
O Robô não pode se movimentar para fora da área especificada;
Não deve guardar estado do robô para consulta posterior;

### Alguns cenários de teste:
Movimento com rotações para direita:
curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
Saída esperada: (2, 0, S)
Movimento para esquerda:
Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
Saída esperada: (0, 2, W)
Repetição da requisição com movimento para esquerda:
Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
Saída esperada: (0, 2, W)
Comando inválido:
curl -s --request POST http://localhost:8080/rest/mars/AAA
Saída esperada: 400 Bad Request
Posição inválida:
curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
Saída esperada: 400 Bad Request

### Requisitos técnicos:
Deve ter teste
O desafio deve ser entregue escrito utilizando Java 8;
O projeto deverá ser compilado utilizando o Maven;
Deverão ser utilizadas apenas as biblioteca do SpringBoot e JUnit;
O desafio será executado como uma aplicação SpringBoot;
A interface de comunicação com o robô é REST;

# Minha solucao

Minha solução é baseada no pattern Command e em uma adaptação do pattern Factory. 
Tenho uma classe Robo que representa o robô proposto no problema. Esse robô é inicializado recebendo um objeto da classe Terreno que representa o terreno.

O robô também possui um objeto imutável que representa a sua posição, que inicialmente é representada (0, 0, N), ou seja, x = 0, y = 0 e apontando para o Norte.

O objeto posição é composto basicamente por uma um Ponto(x, y) e um Sentido (enum) que pode ser N, E, S, W. Cada enumeração possui um valor ordinal para garantir que ele seja declarado na ordem correta. O enum encapsula o comportamento de virar; tanto para a direita quanto para a esquerda. Por exemplo: se estiver na posição S e aportar para a esquerda, ele deve retornar E; se apontar para direita, deve retornar W.

A classe Posicao também encapsula algumas características inerentes à posição, como retornar a próxima posição após um deslocamento. Sempre com objetos imutáveis (@Value do lombok).

Como entrada, o robô recebe uma String especificando os movimentos. Essa string é inicialmente validada por uma Regex simples, desmontada e então, cada um de seus caracteres é submetido à uma fábrica de comandos que, por sua vez, retorna o comando designado pelo caracter. O comando então é executado.

Para a app final, foi criada uma interface rest com o SpringBoot para expor a interface do Robo online. O código de execução do robô foi especificando dentro do próprio controller, uma vez que não havia a necessidade de implementar uma camada de serviços para isso.

Também foi designado um adviser para converter as exceções lançadas pelo robô em Bad Requests, conforme foi especificado no problema.
