package ejercicio2;

public class Reserva {
    Datos datos = new Datos();

    public void setDatos(Datos datos){
        this.datos = datos;
    }
    public String resevaVuelo(String destino, int cantidad, int dia, int mes, int gestion){
        if(dia < 1 || mes < 1|| gestion < 0 || dia > 31 || mes > 12 || dia > 28 && mes==2 && !isLeapYear(gestion)){
            return "fecha no valida";
        }
        if(cantidad < 1){
            return "canntidad incorrecta";

        }
        String month="";
        switch(mes){
            case 1:
                month = "Enero";
                break;
            case 2:
                month="Febrero";
                break;
            case 3:
                month = "Marzo";
                break;
            case 4:
                month="Abril";
                break;
            case 5:
                month = "Mayo";
                break;
            case 6:
                month="Junio";
                break;
            case 7:
                month = "Julio";
                break;
            case 8:
                month="Agosto";
                break;
            case 9:
                month = "Septiembre";
                break;
            case 10:
                month="Octubre";
                break;
            case 11:
                month = "Noviembre";
                break;
            case 12:
                month="Diciembre";
                break;


        }

        return datos.existenPasajes(destino, cantidad) ? "el dia "+Datos.getDay(dia,mes,gestion)+" "+dia+" "+month+" "+gestion+" existen "+cantidad+" pasajes para "+destino: "no existen suficientes pasajes para "+destino;
    }
    public boolean isLeapYear(int num){
        return (num%4==0 && (num%100!=0||num%400==0));
    }
}
