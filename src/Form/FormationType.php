<?php

namespace App\Form;

use App\Entity\Categorie;
use App\Entity\Formation;
use Doctrine\DBAL\Types\DateType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class FormationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom')
            ->add('prix')
            ->add('description')
            ->add('secteur')
            ->add('date')
            ->add('datefin')
            ->add('image',FileType::class,[
                'label'=>'Choisissez une image', 
                'attr' => ['class' => 'form-control'] , 
                 'required'=>false
             ] )
            ->add('idcategorie',EntityType::class,[
                'class'=>Categorie::class,
                'choice_label'=>'nom'
            ])
        ;

    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Formation::class,
        ]);
    }

}
