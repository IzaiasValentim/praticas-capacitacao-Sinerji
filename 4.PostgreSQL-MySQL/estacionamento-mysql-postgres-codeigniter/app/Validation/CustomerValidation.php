<?php

namespace App\Validation;

// Validação dos campos de cadastro.
class CustomerValidation
{
    public function getRules(): array
    {
        return [
            'name' => [
                'label' => 'Nome',
                'rules' => 'required|max_length[128]',
                'errors' => [
                    'required' => 'Obrigatório!',
                    'max_length' => 'Informe no máximo 128 caracteres',
                ]
            ],

            'cpf' => [
                'label' => 'CPF',
                'rules' => 'required|exact_length[14]',
                'errors' => [
                    'required' => 'Obrigatório!',
                    'exact_length' => 'Informe exatamente 14 caracteres',
                ]
            ],

            'email' => [
                'label' => 'E-mail',
                'rules' => 'required|max_length[128]',
                'errors' => [
                    'required' => 'Obrigatório!',
                    'max_length' => 'Informe no máximo 128 caracteres',
                ]
            ],

            'phone' => [
                'label' => 'Telefone',
                'rules' => 'required|max_length[20]',
                'errors' => [
                    'required' => 'Obrigatório!',
                    'max_length' => 'Informe no máximo 20 caracteres',
                ]
            ],
        ];
    }
}
