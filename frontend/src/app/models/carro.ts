import { Acessorio } from "./acessorio";
import { Marca } from "./marca";

export class Carro {
  id!: number;
  nome!: string;
  ano!: number;
  marca!: Marca;
  acessorios: Acessorio[] = [];
}
