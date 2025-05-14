# Sistema de Gestión para Concesionaria de Vehículos 🚗

Este proyecto forma parte del Trabajo Práctico Obligatorio de la materia **Análisis y Diseño Orientado a Objetos** (Proceso de Desarrollo de Software), correspondiente al 1° cuatrimestre de 2025.

## 📋 Descripción del Proyecto

El sistema tiene como objetivo gestionar el proceso completo de compra de vehículos en una concesionaria en Argentina. Cubre desde la selección del vehículo hasta la entrega, incluyendo áreas como ventas, cobranzas, impuestos, logística y más.

## 🧩 Funcionalidades Principales

- **Gestión de clientes**: Registro de nuevos clientes evitando duplicaciones.
- **Catálogo de vehículos**: Consulta y configuración de modelos, colores y equipamientos.
- **Pedidos de compra**: Personalización del vehículo, forma de pago y seguimiento del estado del pedido.
- **Gestión de impuestos**: Cálculo automático de impuestos nacionales y provinciales según el tipo de vehículo.
- **Roles de usuario**: 
  - **Administrador**: Acceso total al sistema.
  - **Vendedor**: Visualización de vehículos disponibles.
  - **Comprador**: Consulta de sus pedidos y vehículos disponibles.
- **Manejo de errores**: Uso de excepciones para evitar inconsistencias.
- **Notificaciones internas**: A las áreas involucradas según el estado del pedido.
- **Generación de informes**: Exportables, con filtros por fecha y estado.

## 💵 Cálculo de Impuestos

El sistema aplica impuestos de forma diferenciada:

- **Impuesto Nacional**:
  - Autos: 21%
  - Camionetas: 10%
  - Motos y Camiones: 0%

- **Impuesto Provincial General**: 5% (todos los vehículos)

- **Impuesto Provincial Adicional**:
  - Camiones y Camionetas: 2%
  - Autos y Motos: 1%

Los cálculos están implementados utilizando estrategias polimórficas para permitir escalabilidad.

## 💳 Formas de Pago

- Contado
- Transferencia
- Tarjeta de crédito

Se usa **herencia y polimorfismo** para facilitar la extensión a nuevas formas de pago sin modificar la estructura existente.

## 🧠 Diseño

- Se aplican principios de **desacoplamiento** y **flexibilidad**.
- Se utilizan patrones de diseño como:
  - Singleton (punto de acceso único)
  - Strategy (cálculo de impuestos)
  - Factory o Builder (creación de objetos, en este caso autos)
  - Observer (notificación de cambios)

## 🛠️ Tecnologías sugeridas

> El lenguaje y tecnologías específicas no se detallan en el documento, pero se recomienda orientarse a un desarrollo en Java con enfoque en POO.

## 🧪 Requisitos funcionales

- No se deben permitir duplicados en clientes, vehículos ni pedidos.
- Seguimiento del estado del pedido (ventas → cobranzas → impuestos → logística → entrega).
- Historial completo de cambios.
- Informes con CUIT y nombre de la concesionaria visibles.

## 📁 Estructura del Proyecto

- `src/` - Código fuente
- `docs/` - Documentación y diagramas UML
- `reports/` - Informes generados
- `README.md` - Este archivo

## 👥 Integrantes

- Solaeche Joel
- Catrinacio Magalí  
- Gantus Elias  
- Avalos Lourdes  
- Calcagno Joshua
- Addamo Juan Segundo 
- Castillo Federico

---

