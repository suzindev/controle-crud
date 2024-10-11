import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { Acessorio } from '../../../models/acessorio';
import { ActivatedRoute } from '@angular/router';
import { AcessorioService } from '../../../services/acessorio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-acessoriosdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './acessoriosdetails.component.html',
  styleUrl: './acessoriosdetails.component.scss'
})
export class AcessoriosdetailsComponent {
  @Input("acessorio") acessorio: Acessorio = new Acessorio();
  @Output("retorno") retorno = new EventEmitter<any>();

  routerActivated = inject(ActivatedRoute);
  acessorioService = inject(AcessorioService);

  constructor() {
    let id = this.routerActivated.snapshot.params['id'];

    if (id > 0) {
      this.acessorioService.findById(id).subscribe({
        next: retorno => {
          this.acessorio = retorno;
        },
        error: erro => {
          Swal.fire({
            title: 'Ocorreu um erro',
            icon: 'error',
            confirmButtonText: 'OK'
          });
        }
      });
    }
  }

  save() {
    if (this.acessorio.id > 0) {
      this.acessorioService.update(this.acessorio, this.acessorio.id).subscribe({
        next: mensagem => {
          Swal.fire({
            title: mensagem,
            icon: 'success',
            confirmButtonText: 'OK'
          });

          this.retorno.emit(this.acessorio);
        },
        error: erro => {
          Swal.fire({
            title: 'Ocorreu um erro',
            icon: 'error',
            confirmButtonText: 'OK'
          });
        }
      });
    } else {
      this.acessorioService.save(this.acessorio).subscribe({
        next: mensagem => {
          Swal.fire({
            title: mensagem,
            icon: 'success',
            confirmButtonText: 'OK'
          });

          this.retorno.emit(this.acessorio);
        },
        error: erro => {
          Swal.fire({
            title: 'Ocorreu um erro',
            icon: 'error',
            confirmButtonText: 'OK'
          });
        }
      });
    }
  }
}
