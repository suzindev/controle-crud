import { Acessorio } from "../models/acessorio";
import { AcessorioRequest } from "../requests/acessorioRequest";

export function toRequest(acessorio: Acessorio): AcessorioRequest {
  return {
    nome: acessorio.nome
  }
}
