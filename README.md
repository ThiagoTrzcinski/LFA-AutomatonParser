# LFA-AutomatonParser

Este projeto é uma ferramenta para testar se palavras são aceitas ou rejeitadas por um autômato, com base na definição fornecida em um arquivo `.jff` (compatível com o software JFLAP). Ele suporta autômatos determinísticos (DFA) e não determinísticos (NFA).

---

## **Funcionalidades**
- **Leitura de Autômatos**: Importa autômatos definidos em arquivos `.jff`.
- **Simulação de Autômatos**: Verifica se palavras em um arquivo `.txt` são aceitas pelo autômato.
- **Suporte a Não Determinismo**: Pode simular autômatos não determinísticos (NFAs).

---

## **Arquitetura do Projeto**

### **Classes Principais**
1. **`JFFParser`**
   - Realiza o parsing do arquivo `.jff` e converte os dados em um modelo de autômato para uso interno.
   - Processa estados, transições e marcação de estados iniciais e finais.

2. **`Automaton`**
   - Representa o autômato, armazenando os estados, transições, estado inicial e estados finais.

3. **`State`**
   - Representa um estado no autômato, identificando-o por um ID e um nome.

4. **`Transition`**
   - Representa uma transição no autômato, armazenando o estado de origem, o símbolo de leitura e o estado de destino.

5. **`AutomatonSimulator`**
   - Simula o funcionamento do autômato, verificando se uma palavra é aceita ou rejeitada.

6. **`WordTester`**
   - Executa a aplicação, testando uma lista de palavras contidas em um arquivo `.txt`.
