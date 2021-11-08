import { Vendedor } from "./vendedor"

export type Venda = {
    id: number,
    visitado: number, 
    promocoes: number,
    quantia: number,
    date: string,
    vendedor: Vendedor
}

export type VendasPaginadas = {
    content?: Venda[],
    last: boolean,
    totalElements: number,
    totalPages: number,
    size?: number,
    number: number,
    first: boolean,
    numberOfElements?: number
    empty?: boolean
}

export type SomaVendas = {
    nomeVendedor: string,
    soma: number
}

export type VendaSucesso = {
    nomeVendedor: string,
    visitado: number,
    promocoes: number
}