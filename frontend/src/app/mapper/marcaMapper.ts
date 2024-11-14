import { Marca } from "../models/marca";
import { MarcaRequest } from "../requests/marcaRequest";

export function toRequest(marca: Marca): MarcaRequest {
  return {
    nome: marca.nome
  }
}
