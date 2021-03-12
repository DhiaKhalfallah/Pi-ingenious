<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AdmiinController extends AbstractController
{
    /**
     * @Route("/admiin", name="admiin")
     */
    public function index(): Response
    {
        return $this->render('admiin/index.html.twig', [
            'controller_name' => 'AdmiinController',
        ]);
    }
}
