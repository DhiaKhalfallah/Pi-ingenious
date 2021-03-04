<?php

namespace App\Form;

use App\Entity\Categorieoffre;
use App\Entity\Offre;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class OffreType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom')
            ->add('email')
            ->add('logo',FileType::class,[
                'mapped' => false
                ])
            ->add('title')
            ->add('description')
            ->add('idcategorie',EntityType::class,[
                'class'=>Categorieoffre::class,
                'choice_label'=>'nom'
                ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Offre::class,
        ]);
    }
}
