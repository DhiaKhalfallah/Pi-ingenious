<?php

namespace App\Controller;

use App\Entity\Formation;
use App\Form\FormationType;
use App\Repository\FormationRepository;
use App\Repository\UserRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;


class FormationController extends AbstractController
{
    /**
     * @Route("/listforma", name="listforma")
     * @isGranted("ROLE_ENTEPRISE")
     */
    public function forma(FormationRepository $repository): Response
    {
        $formations=$repository->findAll();
        return $this->render('formation/listforma.html.twig', [
            'formations'=>$formations
        ]);
    }

    /**
     * @return Response
     * @Route("/add_forma",name="add_forma")
     */
    public function addform ( Request $request, EntityManagerInterface $em , UserRepository $user_rep)
    {
      
        $formation=new Formation();

        $form= $this->createForm(FormationType::class,$formation);
        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()){
            $user = $this->getUser() ; 
            $formation->setStatus("1");
            $formation->addIdUser($user);
            $image =$form->get('image')->getData(); 
            $nomImage = md5(uniqid()).'.'.$image->guessExtension() ;
            $image->move($this->getParameter('uploads_directory'),$nomImage) ; 
            $formation->setImage($nomImage) ; 
            $formation->setUpdatedAt(new \DateTime('now')); 

            $em->persist($formation);
            $em->flush();
            return $this->redirectToRoute('listforma');
        }
        return $this->render('formation/add_form.html.twig',[
            'formation'=>$formation,
            'form'=>$form->createView(),
        ]);
    }

    /**
     * @Route("/listforma/{id}", name="forma")
     */
    public function aff_form($id,FormationRepository $repository): Response
    {
        $formation=$repository->find($id);
        return $this->render('formation/affforma.html.twig', [
            'formation'=>$formation
        ]);
    }
}
