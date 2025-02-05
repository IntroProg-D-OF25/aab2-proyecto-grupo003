def validar_datos(sueldo_mensual, facturas):
    if sueldo_mensual <= 0:
        return False
    for factura in facturas:
        if factura < 0:
            return False
    return True

def calcular_deducciones(facturas, limites_deducciones):
    total_deducciones = sum(min(factura, limite) for factura, limite in zip(facturas, limites_deducciones))
    return total_deducciones

def calcular_impuesto(ingresos_anuales, total_deducciones):
    base_imponible = ingresos_anuales - total_deducciones
    if base_imponible < 0:
        base_imponible = 0
    
    if base_imponible <= 20000:
        return base_imponible * 0.1
    elif base_imponible <= 40000:
        return base_imponible * 0.15
    else:
        return base_imponible * 0.2

def generar_declaracion(ingresos_anuales, total_deducciones, impuesto_a_pagar):
    print("\n--- Declaración de Impuestos ---")
    print(f"Ingresos Anuales: {ingresos_anuales}")
    print(f"Total Deducciones: {total_deducciones}")
    print(f"Impuesto a Pagar: {impuesto_a_pagar}")
    
    if impuesto_a_pagar == 0:
        print("¡Reembolso! Usted tiene una devolución de impuestos.")

def main():
    try:
        sueldo_mensual = float(input("Ingrese su sueldo mensual: "))
        categorias = ["Vivienda", "Educación", "Alimentación", "Vestimenta", "Salud", "Turismo"]
        facturas = []
        
        for categoria in categorias:
            factura = float(input(f"Ingrese las facturas para {categoria}: "))
            facturas.append(factura)
        
        limites_deducciones = [5000, 3000, 2000, 1000, 1500, 2000]
        
        if not validar_datos(sueldo_mensual, facturas):
            print("Error: Los datos ingresados no son válidos.")
            return
        
        total_ingresos_anuales = sueldo_mensual * 12
        total_deducciones = calcular_deducciones(facturas, limites_deducciones)
        impuesto_a_pagar = calcular_impuesto(total_ingresos_anuales, total_deducciones)
        
        generar_declaracion(total_ingresos_anuales, total_deducciones, impuesto_a_pagar)
    except ValueError:
        print("Error: Ingrese un número válido.")

if __name__ == "__main__":
    main()
