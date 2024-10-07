import { Component } from '@angular/core';
import { Carro } from '../../../models/carro';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-carroslist',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './carroslist.component.html',
  styleUrl: './carroslist.component.scss'
})
export class CarroslistComponent {
  lista: Carro[] = [];

  constructor() {
    let carro1: Carro = new Carro();
    carro1.id = 1;
    carro1.nome = "Fiesta";

    let carro2: Carro = new Carro();
    carro2.id = 1;
    carro2.nome = "Uno";

    let carro3: Carro = new Carro();
    carro3.id = 1;
    carro3.nome = "Gol";

    this.lista.push(carro1);
    this.lista.push(carro2);
    this.lista.push(carro3);
  }

  deletar() { }
}
