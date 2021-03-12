<?php

namespace App\Controller;

use App\Entity\Offre;
use App\Form\InterviewType;
use App\Form\OffreType;
use App\Repository\InterviewRepository;
use App\Repository\OffreRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/offre")
 */
class OffreController extends AbstractController
{
    /**
     * @Route("/", name="offre_index", methods={"GET"})
     * 
     */
    public function index(OffreRepository $offreRepository): Response
    {
        return $this->render('offrefront/addoffre.html.twig', [
            'offres' => $offreRepository->findAll(),
        ]);
    }
    

    /**
     * @Route("/myoffre", name="offre_enteprise", methods={"GET"})
     */
    public function myOffre(OffreRepository $offreRepository): Response
    {

        return $this->render('offrefront/entepriseoffre.html.twig', [
            'offres' => $offreRepository->findBy(['enteprise'=>$this->getUser()]),

        ]);
    }

    /**
     * @Route("/myinterview", name="interview_enteprise", methods={"GET"})
     */
    public function myinterview(InterviewRepository $interviewRepository): Response
    {

        return $this->render('offrefront/entepriseinterview.html.twig', [
            'interviews' => $interviewRepository->findBy(['enteprise'=>$this->getUser()]),

        ]);
    }


   
}