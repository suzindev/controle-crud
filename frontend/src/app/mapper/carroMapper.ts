import { Carro } from "../models/carro";
import { CarroRequest } from "../requests/carroRequest";

export function toRequest(carro: Carro): CarroRequest {
  return {
    nome: carro.nome,
    ano: carro.ano,
    idMarca: carro.marca.id,
    idsAcessorios: carro.acessorios.map(m => m.id)
  }
}
