/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.exceptions;

/**
 *
 * @author Beatr
 */
public class EntidadeNaoInformadaException extends Exception{
    
    public EntidadeNaoInformadaException(String entidade){
        super(entidade + " Não foi informada e deve ser preenchida(o). Verifique!");
    }
    
}
