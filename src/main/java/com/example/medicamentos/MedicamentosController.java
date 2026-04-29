package com.example.medicamentos;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicamentosController {

    private final List<Medicamento> medicamentos = List.of(
            new Medicamento(
                    "paracetamol",
                    List.of("Dolex", "Panadol"),
                    List.of("oral", "rectal", "IV"),
                    "500-1000 mg cada 6-8h (máx. 4g/día)",
                    List.of("Fiebre", "Dolor leve a moderado"),
                    List.of("Insuficiencia hepática grave"),
                    List.of("Náuseas", "Hepatotoxicidad"),
                    List.of("No administrar con alcohol", "Controlar función hepática si uso prolongado")
            ),
            new Medicamento(
                    "ibuprofeno",
                    List.of("Advil", "Motrin"),
                    List.of("oral"),
                    "400-600 mg cada 6-8h (máx. 2400 mg/día)",
                    List.of("Fiebre", "Dolor", "Inflamación"),
                    List.of("Úlcera gástrica", "Insuficiencia renal"),
                    List.of("Dolor gástrico", "Náuseas"),
                    List.of("Administrar con alimentos", "Evitar en pacientes con gastritis")
            ),
            new Medicamento(
                    "metoclopramida",
                    List.of("Primperan", "Plasil"),
                    List.of("oral", "IM", "IV"),
                    "10 mg cada 8h",
                    List.of("Náuseas", "Vómito"),
                    List.of("Hemorragia gastrointestinal", "Epilepsia"),
                    List.of("Somnolencia", "Diarrea", "Mareos"),
                    List.of("Observar signos extrapiramidales", "Evitar uso prolongado")
            ),
            new Medicamento(
                    "omeprazol",
                    List.of("Losec", "Zegerid"),
                    List.of("oral"),
                    "20-40 mg al día",
                    List.of("Acidez", "Gastritis", "Reflujo"),
                    List.of("Hipersensibilidad al fármaco"),
                    List.of("Dolor abdominal", "Flatulencia", "Náuseas"),
                    List.of("Administrar en ayunas", "Evaluar eficacia clínica")
            ),
            new Medicamento(
                    "loratadina",
                    List.of("Claritin", "Alerpriv"),
                    List.of("oral"),
                    "10 mg una vez al día",
                    List.of("Rinitis", "Estornudos", "Picazón"),
                    List.of("Insuficiencia hepática grave"),
                    List.of("Somnolencia", "Sequedad bucal"),
                    List.of("Administrar preferiblemente en la noche")
            ),
            new Medicamento(
                    "amoxicilina",
                    List.of("Amoxil", "Trimox"),
                    List.of("oral"),
                    "500 mg cada 8h por 7-10 días",
                    List.of("Infección respiratoria", "Fiebre"),
                    List.of("Alergia a penicilinas"),
                    List.of("Diarrea", "Erupciones cutáneas"),
                    List.of("Verificar antecedentes alérgicos", "Administrar con alimentos")
            ),
            new Medicamento(
                    "diclofenaco",
                    List.of("Voltaren", "Artren"),
                    List.of("oral", "IM", "tópica"),
                    "50 mg cada 8h",
                    List.of("Dolor", "Inflamación"),
                    List.of("Úlcera gástrica", "Asma inducida por AINES"),
                    List.of("Dolor abdominal", "Mareos"),
                    List.of("Usar la mínima dosis eficaz", "Evitar en pacientes con úlcera")
            ),
            new Medicamento(
                    "salbutamol",
                    List.of("Ventolin", "ProAir"),
                    List.of("inhalación"),
                    "1-2 inhalaciones cada 4-6h",
                    List.of("Dificultad para respirar", "Tos"),
                    List.of("Hipertiroidismo no controlado", "Arritmias"),
                    List.of("Temblor", "Taquicardia"),
                    List.of("Supervisar frecuencia cardiaca", "Instruir en técnica de inhalación")
            ),
            new Medicamento(
                    "loperamida",
                    List.of("Imodium"),
                    List.of("oral"),
                    "2 mg después de cada evacuación diarreica (máx. 8 mg/día)",
                    List.of("Diarrea", "Cólicos"),
                    List.of("Colitis ulcerosa", "Diarrea infecciosa"),
                    List.of("Estreñimiento", "Dolor abdominal"),
                    List.of("Suspender si no hay mejora en 48h", "Aumentar líquidos")
            ),
            new Medicamento(
                    "ketorolaco",
                    List.of("Dolac", "Toradol"),
                    List.of("oral", "IM", "IV"),
                    "10 mg cada 6h (máx. 40 mg/día oral)",
                    List.of("Dolor intenso", "Inflamación"),
                    List.of("Úlcera péptica activa", "Insuficiencia renal"),
                    List.of("Náuseas", "Somnolencia", "Dolor gástrico"),
                    List.of("Uso corto plazo", "Evaluar función renal")
            )
    );

    @GetMapping("/")
    public String prueba() {
        return "¡Hola, mundo!";
    }
    
    @GetMapping("/medicamentos")
    public List<Medicamento> listaDeMedicamentos(){
        return medicamentos;
    }

    @GetMapping("/sintoma")
    public List<Medicamento> sintoma(@RequestParam String sintoma){
        List<Medicamento> medicamentosConSintoma = new ArrayList<>();
        for(Medicamento medicamento:medicamentos){
            if(medicamento.getIndicaciones().contains(sintoma)){
                medicamentosConSintoma.add(medicamento);
            }
        }
        return medicamentosConSintoma;
    }
}
