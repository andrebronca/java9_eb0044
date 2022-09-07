package com.jdojo.intro;

import java.util.ArrayList;
import java.util.List;

/**
 * Fiquei interessado em percorrer as opções de Unicode Character.
 * Tive que fazer o scape abaixo para a classe compilar. Compilador leu o
 * comentário e travou, fechou sem aviso o NetBeans.
 * o padrão: ''\\uxxxx'', xxxx são hexadecimais.
 * Como percebi que a geração de códigos unicode traziam simbolos diferentes,
 * quis ver quais eram esses símbolos (únicos) e os seus respectivos códigos.
 * Lembrando que ao adicionar um símbolo, uma lista correspondente é criada com
 * o código unicode, há outro código para o mesmo símbolo, mas aqui eu só preciso
 * de uma referência de código e qual símbolo corresponde.
 * Poderia ser um hashMap, mas usei apenas lista.
 * O código só tem a função de exibir, não precisa ser o melhor código.
 * A execução do programa via terminal exibe os mesmos códigos listados na IDE 
 * NetBeans 13. Porém, quando executo via jshell os valores retornam símbolos
 * diferentes.
 * @author andrebronca
 */
public class TestScapeChar {
    public static void main(String[] args) {
        char[] ac = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','F'};
        List<String> lista = new ArrayList<>();
        List<String> codigo = new ArrayList<>();
        
        int tam = ac.length;
        int q = 1;
        int total = 0;
        
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                for(int k = 0; k < tam; k++){
                    for(int m = 0; m < tam; m++){
                        q++;
                        total++;
                        char c = (char) ('\\' + 'u' + ac[i] + ac[j] + ac[k] + ac[m]);
//                        CharSequence cs = new StringBuilder().append(c);
                        String s = String.valueOf(c);
                        if (!lista.contains(s)){
                            lista.add(s);
                            codigo.add("\\u"+ ac[i] + ac[j] + ac[k] + ac[m] );
                        }
//                        System.out.print(
//                                "\\u"+ ac[i] + ac[j] + ac[k] + ac[m] +" -> "+ c +", "
//                        );
                        
                        if (q == 8){
                            //System.out.println();
                            q = 1;
                        }
                    }
                }
            }
        } //for i
        System.out.println("Total de combinações: "+ total);
        System.out.println("Tamanho da lista: "+ lista.size());
        
        int pos = 0;
        int i = 0;
        for(String s : lista){
            pos++;
            System.out.print( "'"+ codigo.get(i++) +"' -> "+  s +", ");
            if (pos == 8){
                System.out.println();
                pos = 0;
            }
        }
        System.out.println();        
    }
}
