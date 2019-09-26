package com.example.calculadora;
import java.util.Stack;
public class Evaluador {
    Stack<String> pilaNum;//Stack<String> pilaNum = new Stack<String>();
    Stack<String> pilaOp;//Stack<String> pilaOp = new Stack<String>();
    Stack<String> exp;
    Stack<String> exp2;
    String [] opUna={"¬","Log","ln","!","Sqrt","Sen","Cos","Tan","Ctg","Csc","Sec"};
    String [] opBin={"+","-","*","/","^","%"};
    double pi;//double pi=3.141592;
    double e;//double e=2.718281;

    public Evaluador() {
        this.pilaNum = new Stack<String>();
        this.pilaOp = new Stack<String>();
        this.exp = new Stack<String>();
        this.exp2 = new Stack<String>();
        this.pi=3.141592;
        this.e=2.718281;
        //String [] opList={"+","-","*","/","^","%","¬","(",")","Log","ln","!","Sqrt","Sen","Cos","Tan","Ctg","Csc","Sec"};
    }
    public boolean isNum(String c) {
        boolean resultado;
        try {
            Double.parseDouble(c);
            resultado = true;
        }
        catch (NumberFormatException excepcion) {
            if(c.compareTo("pi")==0){
                resultado = true;
            }
            else if(c.compareTo("e")==0){
                resultado = true;
            }
            else{
                resultado = false;
            }
        }

        return resultado;
    }
    public void separaCad(String cadPos){
        String aux="";
        for(int i=1; i<cadPos.length(); i++){
            if(cadPos.charAt(i)=='#'){
                //System.out.println("Se desprecia #\n");
                exp.push(aux);
                aux="";
            }
            else{
                aux=aux+cadPos.charAt(i);
            }
        }
        exp.push(aux);
        String token;
        while(!exp.empty()){
            token=exp.pop();
            exp2.push(token);
        }

    }
    public boolean isUnario(String c){
        boolean res=false;
        for(int i=0; i<opUna.length; i++){
            if(c.compareTo(opUna[i])==0){
                res=true;
                break;
            }
        }
        return res;
    }
    public boolean isBinario(String c){
        boolean res=false;
        for(int i=0; i<opBin.length; i++){
            if(c.compareTo(opBin[i])==0){
                res=true;
                break;
            }
        }
        return res;
    }
    public String evaluar(String cadPos){
        separaCad(cadPos);
        double a = 0 ,b = 0,res;
        String token;
        while(!exp2.empty()){
            token=exp2.pop();
            //System.out.println("TOKEN "+token+"\n");
            if(isNum(token)){ //si es un num
                if(token.compareTo("pi")==0){
                    pilaNum.push(Double.toString(pi));
                }
                else if(token.compareTo("e")==0){
                    pilaNum.push(Double.toString(e));
                }
                else{
                    pilaNum.push(token);
                }
            }
            else if(isUnario(token)){//si es un operador unario {"¬","Log","ln","!","Sqrt","Sen","Cos","Tan","Ctg","Csc","Sec"};
                try {
                    b=Double.parseDouble(pilaNum.pop());
                    if(token.compareTo("¬")==0){
                        //System.out.println("Se hace "+b+" *-1 : ");
                        b = b*-1;
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("Log")==0){
                        //System.out.println("Se hace Log "+b+" : ");
                        b = Math.log10(b);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("ln")==0){
                        //System.out.println("Se hace ln "+b+" : ");
                        b = Math.log10(b) / Math.log10(e);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("!")==0){
                        //System.out.println("Se hace ! "+b+" : ");
                        long factorial=1L;
                        for(int i=(int)b;i>0;i--) {
                            factorial=factorial*i;
                        }
                        pilaNum.push(factorial+"");
                    }
                    else if(token.compareTo("Sqrt")==0){
                        //System.out.println("Se hace Sqrt "+b+" : ");
                        b = Math.sqrt(b);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("Sen")==0){
                        //System.out.println("Se hace Sen "+b+" : ");
                        b = Math.sin(b);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("Cos")==0){
                        //System.out.println("Se hace Cos "+b+" : ");
                        b = Math.cos(b);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("Tan")==0){
                        //System.out.println("Se hace tan "+b+" : ");
                        b = Math.tan(b);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("Sec")==0){
                        //System.out.println("Se hace sec "+b+" : ");
                        b = 1/Math.cos(b);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("Csc")==0){
                        //System.out.println("Se hace csc "+b+" : ");
                        b = 1/Math.sin(b);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                    else if(token.compareTo("Ctg")==0){
                        //System.out.println("Se hace ctg "+b+" : ");
                        b = 1/Math.tan(b);
                        //System.out.println(b+"\n");
                        pilaNum.push(b+"");
                    }
                }
                catch (NumberFormatException excepcion) {
                    //System.out.println("Error :c\n");
                }
            }
            else if(isBinario(token)){ // {"+","-","*","/","^","%"};
                try {
                    b=Double.parseDouble(pilaNum.pop());
                    a=Double.parseDouble(pilaNum.pop());
                    if(token.compareTo("+")==0){
                        //System.out.println("Se hace "+a+" + "+b+" : ");
                        res = a+b;
                        //System.out.println(res+"\n");
                        pilaNum.push(res+"");
                    }
                    else if(token.compareTo("-")==0){
                        //System.out.println("Se hace "+a+" - "+b+" : ");
                        res = a-b;
                        //System.out.println(res+"\n");
                        pilaNum.push(res+"");
                    }
                    else if(token.compareTo("*")==0){
                        res = a*b;
                        //System.out.println("Se hace "+a+" * "+b+" : "+res+"\n");
                        pilaNum.push(res+"");
                    }
                    else if(token.compareTo("/")==0){
                        res = a/b;
                        //System.out.println("Se hace "+a+" / "+b+" : "+res+"\n");
                        pilaNum.push(res+"");
                    }
                    else if(token.compareTo("^")==0){
                        res = Math.pow(a, b);
                        //System.out.println("Se hace "+a+" ^ "+b+" : "+res+"\n");
                        pilaNum.push(res+"");
                    }
                    else if(token.compareTo("%")==0){
                        res = a%b;
                        //System.out.println("Se hace "+a+" % "+b+" : "+res+"\n");
                        pilaNum.push(res+"");
                    }
                }
                catch (NumberFormatException excepcion) {
                    //System.out.println("Error :c\n");
                }
            }//FIN BINARIO
        }//FIN WHILE
        //System.out.println("El resultado FINAL es: "+pilaNum.pop());
        return pilaNum.pop();
    }
}
