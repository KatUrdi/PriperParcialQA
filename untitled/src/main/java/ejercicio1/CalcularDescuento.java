package ejercicio1;

public class CalcularDescuento {
   public int devDescuento (int sueldo) throws Exception{
       if(sueldo>0 && sueldo<= 2000){
           return sueldo;
       }else if (sueldo>2000 && sueldo<=4000){
           return sueldo - sueldo*5/100;
       }else if (sueldo>40000){
           return sueldo - sueldo*15/100;
       }else{
           throw new Exception("ERROR, el sueldo que se ingreso es incorrecto");
       }
   }
}
